package vo;

public class BookVO {
    String bookId;
    String bookName;
    String editor;
    String price;
    String publisher;

    public BookVO(String bookId, String bookName, String editor, String price, String publisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.editor = editor;
        this.price = price;
        this.publisher = publisher;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
