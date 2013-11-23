package edu.stanford.nlp.ling;

import java.util.Properties;

import junit.framework.TestCase;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.AnnotationLookup;
import edu.stanford.nlp.ling.AnnotationLookup.KeyLookup;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.ExtendedAnnotation;

public class ExternalAnnotationsTest extends TestCase {

  public static class TestAnnotation implements ExtendedAnnotation {

    public Class getType() {
      return String.class;
    }

    public String getTextKey() {
      return "testAnnotation";
    }
     
  }

  public void testExternalAnnotations() {
    String externalAnnotationClass = TestAnnotation.class.getName();
    Properties properties = new Properties();
    properties.setProperty("externalAnnotation.1", externalAnnotationClass);
    CRFClassifier<CoreLabel> crf = new CRFClassifier<CoreLabel>(properties);
    
    Class<?> valueType = AnnotationLookup.getValueType(TestAnnotation.class);
    assertEquals(valueType.getName(), "java.lang.String");

    KeyLookup keyLookup = AnnotationLookup.getCoreKey("testAnnotation");
    assertNotNull(keyLookup);
    assertEquals(keyLookup.coreKey.getName(), externalAnnotationClass);
  }
}