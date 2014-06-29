module StarterSpec where
 
-- Details of Hspec at http://hspec.github.io
 
import Test.Hspec

get :: (Eq a) => a -> [(a,b)] -> Maybe b
get key ((a,b) : kvs) = if a == key then Just b else get key kvs
get key [] = Nothing
 
main :: IO ()
main = hspec $ do
  describe "hash" $ do
-- Write a function that looks up a hash table using Maybe monad
    it "should lookup value" $
      get 1 [(1, "a")] `shouldBe` Just "a"
    it "should lookup first value in list of multiple items" $
      get 'x' [('x', "y"), ('z', "yy")] `shouldBe` Just "y"
    it "should lookup value not the first in list of multiple items" $
      get 'z' [('x', "y"), ('z', "yy")] `shouldBe` Just "yy"
    it "should return Nothing for lookup value not in list of multiple items" $
      get "hello" [("finding", "nemo"), ("toy","story"), ("monsters", "university")] `shouldBe` Nothing
    it "should lookup first value in duplicate key entries" $
      get 'x' [('x', 1.1), ('x', 2.0)] `shouldBe` Just 1.1
    it "should return Nothing" $
      get 1 emptyList `shouldBe` Nothing
-- Write a hash that stores other hashes, using Maybe monad to retrieve nested elements
    it "should return nested hash table" $
      let nestedTable = [(1, 234)]
        in get 1 [(1, nestedTable)] `shouldBe` Just nestedTable
    it "should return nested value in nested table" $
      let nestedTable = [(1, 234)]
	in get [1, 1] [(1, nestedTable)] `shouldBe` Just 234

emptyList :: [(Int, String)]
emptyList = []
