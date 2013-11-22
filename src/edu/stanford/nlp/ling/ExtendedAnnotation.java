package edu.stanford.nlp.ling;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.TypesafeMap;

/**
 * The base class for annotations developed outside the CoreNLP package. 
 * Like a (@link CoreAnnotation), subclasses of this class are the keys 
 * in the {@link CoreMap}, so they are instantiated only by utility methods
 * in {@link CoreAnnotations}.
 */
public interface ExtendedAnnotation<V> 
  extends CoreAnnotation<V> {
  /**
   * Returns the text string associated with this annotation.
   */
  public String getTextKey();
}
