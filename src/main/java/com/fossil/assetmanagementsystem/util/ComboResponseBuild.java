package com.fossil.assetmanagementsystem.util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component

public class ComboResponseBuild<T,E> {


    public Function<List<T>,Response> listResponseFunction= obj->{
        Response response=new Response();
        response.setList(obj);
        return response;
    };

    public Function<Page<T>,Response> pageResponseFunction= obj->{
        Response response=new Response();
        response.setPage(obj);
        return response;
    };
}
