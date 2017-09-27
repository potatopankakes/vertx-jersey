package com.englishtown.vertx.jersey.examples.guice.resources;

import com.englishtown.vertx.jersey.examples.guice.ITest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class TestMessageBodyReader
    implements MessageBodyReader<ITest> {
  private String t;

  @Inject
  public TestMessageBodyReader(
      @Named("MyString") String s
  ) {
    System.out.println("TestMessageBodyReader - constructor");
    t = "Without constructor injection";
    t = s;
  }

  @Override
  public boolean isReadable(
      Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType
  ) {
    System.out.println("TestMessageBodyReader - isReadable");
    return aClass.isAssignableFrom(ITest.class);
  }

  @Override
  public ITest readFrom(
      Class<ITest> aClass,
      Type type,
      Annotation[] annotations,
      MediaType mediaType,
      MultivaluedMap<String, String> multivaluedMap,
      InputStream inputStream
  )
      throws IOException, WebApplicationException {
    System.out.println("TestMessageBodyReader - readFrom");
    return new ITest() {
      @Override
      public String get() {
        return t;
      }
    };
  }
}
