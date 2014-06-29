// src/test/scala/testTextSizer.scala

import org.scalatest._
import TextSizer._

class TestTextSizer extends FunSpec with ShouldMatchers {

  // def sizer(list : List[String]) = {
  //   list.foldLeft(0) ((a,b) => a + b.size)
  // }

  describe("A text sizer") {
    it("should give length zero") {
      sizer(List()) should be (0)
    }
    it("should give length 1 for one element size 1") {
    	sizer(List("A")) should be (1)
    }
    it("should give length 2 for two elements size 1") {
    	sizer(List("A", "B")) should be (2)	
    }
    it("should give length 2 for one elements size 2") {
    	sizer(List("AB")) should be (2)	
    }
    it("should give length 4 for AB and CD") {
    	sizer(List("AB", "CD")) should be (4)	
    }
    it("should give length 14 for AB, CD, EFG, H, IJKLMN") {
    	sizer(List("AB", "CD", "EFG", "H", "IJKLMN")) should be (14)
    }

  }
}