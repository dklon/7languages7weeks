import scala.io.Source.fromFile

trait StringCensor {

	def mapping : List[(String, String)]

	def censor(string : String) : String =  {
		mapping.foldLeft(string){case (a, (k,v)) => a.replaceAllLiterally(k,v)}
	}
}

trait staticMapping {

	def mapping : List[(String, String)] = 
		List (
			("Shoot", "Pucky"),
			("shoot", "pucky"),
			("Darn", "Beans"), 
			("darn", "beans") 
		)

}

trait fileMapping {

	def mapping : List[(String, String)] = {
		fromFile("words.csv", "utf-8")
			.mkString.split("\n").toList
    		.map(t => (t.split(",")(0), t.split(",")(1)))
	}
	
}