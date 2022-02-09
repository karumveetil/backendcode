package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    ArrayList<Books> bookList = new ArrayList<Books>();

    @PostMapping("/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Books addBooks(@RequestBody Books book) {
		book.setId(bookList.size()+1);
		bookList.add(book);
        return book;
    }

    @GetMapping("/api/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Books> readBooks() {
        return bookList;
    }

    @DeleteMapping("/api/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBooks() {
        bookList.clear();
    }
}
