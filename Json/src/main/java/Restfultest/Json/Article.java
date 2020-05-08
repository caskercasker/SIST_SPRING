package Restfultest.Json;

	public class Article {
	   
	  private long seq;
	  private String title;
	  private String text;
	  private String writer;
	  public String getTitle() {
	    return title;
	  }
	  public void setTitle(String title) {
	    this.title = title;
	  }
	  public String getText() {
	    return text;
	  }
	  public void setText(String text) {
	    this.text = text;
	  }
	  public String getWriter() {
	    return writer;
	  }
	  public void setWriter(String writer) {
	    this.writer = writer;
	  }
	  public long getSeq() {
	    return seq;
	  }
	  public void setSeq(long seq) {
	    this.seq = seq;
	  }
	}
