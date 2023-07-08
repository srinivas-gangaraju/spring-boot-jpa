package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PagingAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination(){
        int pageNo = 0;
        int pageSize = 5;
        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //findAll method and pass pageable object

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(System.out::println);

        //total pages
        int totalPages =  page.getTotalPages();
        System.out.println("Total Pages: "+totalPages);
        //total elements
        long totalElements = page.getTotalElements();
        System.out.println("Total Elements: "+totalElements);
        //no of elements
        int noOfElements = page.getNumberOfElements();
        System.out.println("No of Elements: "+noOfElements);
        //size
        int size = page.getSize();
        System.out.println("Size: "+size);
        //last
        boolean isLast = page.isLast();
        System.out.println("Last Page: "+isLast);
        //first
        boolean isFirst = page.isFirst();
        System.out.println("First Page: "+isFirst);
    }

    @Test
    void sorting(){

        String sortBy = "price";
        String sortDir = "desc";
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Product> products = productRepository.findAll(sort);
        products.forEach(System.out::println);

    }

    @Test
    void sortingByMultipleFields(){

        String sortBy = "name";
        String sortByDesc = "description";

        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach(System.out::println);
    }

    @Test
    void paginationAndSorting(){
        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 0;
        int pageSize = 5;
        //sort object

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        //findAll method and pass pageable object

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(System.out::println);


        //total pages
        int totalPages =  page.getTotalPages();
        System.out.println("Total Pages: "+totalPages);
        //total elements
        long totalElements = page.getTotalElements();
        System.out.println("Total Elements: "+totalElements);
        //no of elements
        int noOfElements = page.getNumberOfElements();
        System.out.println("No of Elements: "+noOfElements);
        //size
        int size = page.getSize();
        System.out.println("Size: "+size);
        //last
        boolean isLast = page.isLast();
        System.out.println("Last Page: "+isLast);
        //first
        boolean isFirst = page.isFirst();
        System.out.println("First Page: "+isFirst);

    }

}
