import org.scalatest._

class TestCensorTrait extends FunSpec 
	with ShouldMatchers with StringCensor with fileMapping {

  describe("A censor") {
    it("should censor 'Hello, World' to 'Hello, World'") {
    	censor("Hello, World") should be ("Hello, World")
    }
    it("should censor 'Shoot' to 'Pucky'") {
    	censor("Shoot") should be ("Pucky")
    }
    it("should censor 'Darn' to 'Beans'") {
    	censor("Darn") should be ("Beans")
    }
    it("should censor 'Hello, Darn' to 'Hello, Beans'") {
    	censor("Hello, Darn") should be ("Hello, Beans")
    }
    it("should censor 'Hello, Shoot' to 'Hello, Pucky'") {
    	censor("Hello, Shoot") should be ("Hello, Pucky")
    }
    it("should censor 'Hello, Shoot, World, Darn' to 'Hello, Pucky, World, Beans'") {
    	censor("Hello, Shoot, World, Darn") should be ("Hello, Pucky, World, Beans")
    }
    it("should censor 'shoot' to 'pucky'") {
    	censor("shoot") should be ("pucky")
    }
    it("should censor 'darn' to 'beans'") {
    	censor("darn") should be ("beans")
    }
  }
}