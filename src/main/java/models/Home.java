package models;

public class Home {
	private final long id;
	  private final String content;

	  public Home(long id, String content) {
	    this.id = id;
	    this.content = content;
	  }

	  public long getId() {
	    return id;
	  }

	  public String getContent() {
	    return content;
	  }
}
