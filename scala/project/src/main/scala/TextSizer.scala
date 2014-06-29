

  object TextSizer {

	  def sizer(list : List[String]) = {
	    list.foldLeft(0) ((a,b) => a + b.size)
	  }

  }