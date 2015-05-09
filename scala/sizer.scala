import scala.io._
import scala.actors._
import scala.xml._
import Actor._

// START:loader
object PageLoader {
 val reg = "<link.*/>".r

 def getLinks(pageSource : String) = {
 	val regMatches = reg.findAllIn(pageSource)
 	def getUrl(text : String) = (XML.loadString(text) \ "@href".mkString
 	regMatches.map(getUrl)
 }
 def getPageSize(url : String) = io.Source.fromURL(url).mkString.length
 def getNumberOfLinks(url : String) = reg.findAllIn(io.Source.fromURL(url).mkString).size
 def getIndirectPageSize(url : String) = {
 	val pageSource = io.Source.fromURL(url).mkString
 	val links = getLinks(pageSource)
 	links.foldLeft(pageSource.size)((sum, link) => sum + getPageSize(link))
 }
}
// END:loader

val urls = List("http://www.moo.com/",
               "http://www.twitter.com/",
               "http://www.google.com/",
               "http://www.cnn.com/" )

// START:time
def timeMethod(method: () => Unit) = {
 val start = System.nanoTime
 method()
 val end = System.nanoTime
 println("Method took " + (end - start)/1000000000.0 + " seconds.")
}
// END:time

// START:sequential
def getPageSizeSequentially() = {
 for(url <- urls) {
   println("Size for " + url + ": " + PageLoader.getPageSize(url))
 }
}
// END:sequential

// START:concurrent
def getPageSizeConcurrently() = {
 val caller = self

 for(url <- urls) {
   actor { caller ! (url, PageLoader.getPageSize(url), PageLoader.getNumberOfLinks(url), PageLoader.getIndirectPageSize(url)) }
 }

 for(i <- 1 to urls.size) {
   receive {
     case (url, size, numLinks, indirectsize) =>
       println("====================================")
       println("Size for " + url + ": " + size)
       println("Num links for " + url + " " + numLinks)
       println("Bonus size for " + url + " " + indirectsize)            
   }
 }
}
// END:concurrent

// START:script
println("Sequential run:")
timeMethod { getPageSizeSequentially }

println("Concurrent run")
timeMethod { getPageSizeConcurrently }
// END:script