package edu.stanford.nlp.ling;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.AnnotationLookup.KeyLookup;
import edu.stanford.nlp.ling.CoreLabel.GenericAnnotation;
import edu.stanford.nlp.util.ErasureUtils;
import edu.stanford.nlp.util.Generics;

/** @author Anna Rafferty */
public class AnnotationLookup {

  private AnnotationLookup() {}

  public static class KeyLookup {
    private static List<KeyLookup> values = new LinkedList<KeyLookup>();
    static {
      add(CoreAnnotations.ValueAnnotation.class, OldFeatureLabelKeys.VALUE_KEY);
      add(CoreAnnotations.PartOfSpeechAnnotation.class, OldFeatureLabelKeys.TAG_KEY);
      add(CoreAnnotations.TextAnnotation.class, OldFeatureLabelKeys.WORD_KEY);
      add(CoreAnnotations.LemmaAnnotation.class, OldFeatureLabelKeys.LEMMA_KEY);
      add(CoreAnnotations.CategoryAnnotation.class, OldFeatureLabelKeys.CATEGORY_KEY);
      add(CoreAnnotations.ProjectedCategoryAnnotation.class, OldFeatureLabelKeys.PROJ_CAT_KEY);
      add("edu.stanford.nlp.ling.TreeCoreAnnotations.HeadWordAnnotation", OldFeatureLabelKeys.HEAD_WORD_KEY);
      add("edu.stanford.nlp.ling.TreeCoreAnnotations.HeadTagAnnotation", OldFeatureLabelKeys.HEAD_TAG_KEY);
      add(CoreAnnotations.IndexAnnotation.class, OldFeatureLabelKeys.INDEX_KEY);
      add(CoreAnnotations.ArgumentAnnotation.class, OldFeatureLabelKeys.ARG_KEY);
      add(CoreAnnotations.MarkingAnnotation.class, OldFeatureLabelKeys.MARKING_KEY);
      add(CoreAnnotations.SemanticHeadWordAnnotation.class, OldFeatureLabelKeys.SEMANTIC_HEAD_WORD_KEY);
      add(CoreAnnotations.SemanticHeadTagAnnotation.class, OldFeatureLabelKeys.SEMANTIC_HEAD_POS_KEY);
      add(CoreAnnotations.VerbSenseAnnotation.class, OldFeatureLabelKeys.VERB_SENSE_KEY);
      add(CoreAnnotations.CategoryFunctionalTagAnnotation.class, OldFeatureLabelKeys.CATEGORY_FUNCTIONAL_TAG_KEY);
      add(CoreAnnotations.NamedEntityTagAnnotation.class, OldFeatureLabelKeys.NER_KEY);
      add(CoreAnnotations.ShapeAnnotation.class, OldFeatureLabelKeys.SHAPE_KEY);
      add(CoreAnnotations.LeftTermAnnotation.class, OldFeatureLabelKeys.LEFT_TERM_KEY);
      add(CoreAnnotations.ParentAnnotation.class, OldFeatureLabelKeys.PARENT_KEY);
      add(CoreAnnotations.SpanAnnotation.class, OldFeatureLabelKeys.SPAN_KEY);
      add(CoreAnnotations.BeforeAnnotation.class, OldFeatureLabelKeys.BEFORE_KEY);
      add(CoreAnnotations.AfterAnnotation.class, OldFeatureLabelKeys.AFTER_KEY);
      add(CoreAnnotations.OriginalTextAnnotation.class, OldFeatureLabelKeys.CURRENT_KEY);
      add(CoreAnnotations.AnswerAnnotation.class, OldFeatureLabelKeys.ANSWER_KEY);
      add(CoreAnnotations.GoldAnswerAnnotation.class, OldFeatureLabelKeys.GOLDANSWER_KEY);
      add(CoreAnnotations.FeaturesAnnotation.class, OldFeatureLabelKeys.FEATURES_KEY);
      add(CoreAnnotations.InterpretationAnnotation.class, OldFeatureLabelKeys.INTERPRETATION_KEY);
      add(CoreAnnotations.RoleAnnotation.class, OldFeatureLabelKeys.ROLE_KEY);
      add(CoreAnnotations.GazetteerAnnotation.class, OldFeatureLabelKeys.GAZETTEER_KEY);
      add(CoreAnnotations.StemAnnotation.class, OldFeatureLabelKeys.STEM_KEY);
      add(CoreAnnotations.PolarityAnnotation.class, OldFeatureLabelKeys.POLARITY_KEY);
      add(CoreAnnotations.ChineseCharAnnotation.class, OldFeatureLabelKeys.CH_CHAR_KEY);
      add(CoreAnnotations.ChineseOrigSegAnnotation.class, OldFeatureLabelKeys.CH_ORIG_SEG_KEY);
      add(CoreAnnotations.ChineseSegAnnotation.class, OldFeatureLabelKeys.CH_SEG_KEY);
      add(CoreAnnotations.CharacterOffsetBeginAnnotation.class, OldFeatureLabelKeys.BEGIN_POSITION_KEY);
      add(CoreAnnotations.CharacterOffsetEndAnnotation.class, OldFeatureLabelKeys.END_POSITION_KEY);
      add(CoreAnnotations.DocIDAnnotation.class, OldFeatureLabelKeys.DOCID_KEY);
      add(CoreAnnotations.SentenceIndexAnnotation.class, OldFeatureLabelKeys.SENTINDEX_KEY);
      add(CoreAnnotations.IDFAnnotation.class, "idf");
      add(CoreAnnotations.CharacterOffsetEndAnnotation.class, "endPosition");
      add(CoreAnnotations.ChunkAnnotation.class, "chunk");
      add(CoreAnnotations.NormalizedNamedEntityTagAnnotation.class, "normalized");
      add(CoreAnnotations.MorphoNumAnnotation.class,"num");
      add(CoreAnnotations.MorphoPersAnnotation.class,"pers");
      add(CoreAnnotations.MorphoGenAnnotation.class,"gen");
      add(CoreAnnotations.MorphoCaseAnnotation.class,"case");
      add(CoreAnnotations.WordnetSynAnnotation.class,"wordnetsyn");
      add(CoreAnnotations.ProtoAnnotation.class,"proto");
      add(CoreAnnotations.DocTitleAnnotation.class,"doctitle");
      add(CoreAnnotations.DocTypeAnnotation.class,"doctype");
      add(CoreAnnotations.DocDateAnnotation.class,"docdate");
      add(CoreAnnotations.DocSourceTypeAnnotation.class,"docsourcetype");
      add(CoreAnnotations.LinkAnnotation.class,"link");
      add(CoreAnnotations.SpeakerAnnotation.class,"speaker");
      add(CoreAnnotations.AuthorAnnotation.class,"author");
      add(CoreAnnotations.SectionAnnotation.class,"section");
      add(CoreAnnotations.SectionIDAnnotation.class,"sectionID");
      add(CoreAnnotations.SectionDateAnnotation.class,"sectionDate");

      // Thang Sep13: for Genia NER
      add(CoreAnnotations.HeadWordStringAnnotation.class, "head");
      add(CoreAnnotations.GovernorAnnotation.class, "governor");
      add(CoreAnnotations.GazAnnotation.class, "gaz");
      add(CoreAnnotations.AbbrAnnotation.class, "abbr");
      add(CoreAnnotations.AbstrAnnotation.class, "abstr");
      add(CoreAnnotations.FreqAnnotation.class, "freq");
      add(CoreAnnotations.WebAnnotation.class, "web");

      // Also have "pos" for PartOfTag (POS is also the TAG_KEY - "tag", but "pos" makes more sense)
      // Still keep "tag" for POS tag so we don't break anything
      add(CoreAnnotations.PartOfSpeechAnnotation.class, "pos");
    }

    public final Class coreKey;
    public final String oldKey;
    
    public static <T> void add(Class<? extends CoreAnnotation<T>> coreKey, String oldKey) {
      values.add(new KeyLookup(coreKey, oldKey));
    }

    public static void add(String className, String oldKey) {
      values.add(new KeyLookup(className, oldKey));
    }

    public static List<KeyLookup> values() {
       return values;
    }
    
    private <T> KeyLookup(Class<? extends CoreAnnotation<T>> coreKey, String oldKey) {
      this.coreKey = coreKey;
      this.oldKey = oldKey;
    }

    /**
     * This constructor allows us to use reflection for loading old class keys.
     * This is useful because we can then create distributions that do not have
     * all of the classes required for all the old keys (such as trees package classes).
     */
    private KeyLookup(String className, String oldKey) {
      Class<?> keyClass;
      try {
       keyClass = Class.forName(className);
      } catch(ClassNotFoundException e) {
        GenericAnnotation<Object> newKey = new GenericAnnotation<Object>() {
          public Class<Object> getType() { return Object.class;} };
        keyClass = newKey.getClass();
      }
      this.coreKey = ErasureUtils.uncheckedCast(keyClass);
      this.oldKey = oldKey;
    }


  }

  /**
   * Returns a CoreAnnotation class key for the given old-style FeatureLabel
   * key if one exists; null otherwise.
   */
  public static KeyLookup getCoreKey(String oldKey) {
    for (KeyLookup lookup : KeyLookup.values()) {
      if (lookup.oldKey.equals(oldKey)) {
        return lookup;
      }
    }
    return null;
  }

  private static Map<Class<CoreAnnotation<?>>,Class<?>> valueCache = Generics.newHashMap();

  /**
   * Returns the runtime value type associated with the given key.  Caches
   * results.
   */
  @SuppressWarnings("unchecked")
  public static Class<?> getValueType(Class<? extends CoreAnnotation> key) {
    Class type = valueCache.get(key);
    if (type == null) {
      try {
        type = key.newInstance().getType();
      } catch (Exception e) {
        throw new RuntimeException("Unexpected failure to instantiate - is your key class fancy?", e);
      }
      valueCache.put((Class)key, type);
    }
    return type;
  }

  /**
   * Lookup table for mapping between old-style *Label keys and classes
   * the provide comparable backings in the core.
   */
//OLD keys kept around b/c we're kill IndexedFeatureLabel and these keys used to live there
  private static class OldFeatureLabelKeys {

    public static final String DOCID_KEY = "docID";
    public static final String SENTINDEX_KEY = "sentIndex";
    public static final Object WORD_FORMAT = "WORD_FORMAT";
    public static final Object WORD_TAG_FORMAT = "WORD_TAG_FORMAT";
    public static final Object WORD_TAG_INDEX_FORMAT = "WORD_TAG_INDEX_FORMAT";
    public static final Object VALUE_FORMAT = "VALUE_FORMAT";
    public static final Object COMPLETE_FORMAT = "COMPLETE_FORMAT";
    public static final String VALUE_KEY = "value";
    public static final String TAG_KEY = "tag";
    public static final String WORD_KEY = "word";
    public static final String LEMMA_KEY = "lemma";
    public static final String CATEGORY_KEY = "cat";
    public static final String PROJ_CAT_KEY = "pcat";
    public static final String HEAD_WORD_KEY = "hw";
    public static final String HEAD_TAG_KEY = "ht";
    public static final String INDEX_KEY = "idx";
    public static final String ARG_KEY = "arg";
    public static final String MARKING_KEY = "mark";
    public static final String SEMANTIC_HEAD_WORD_KEY = "shw";
    public static final String SEMANTIC_HEAD_POS_KEY = "shp";
    public static final String VERB_SENSE_KEY = "vs";
    public static final String CATEGORY_FUNCTIONAL_TAG_KEY = "cft";
    public static final String NER_KEY = "ner";
    public static final String SHAPE_KEY = "shape";
    public static final String LEFT_TERM_KEY = "LEFT_TERM";
    public static final String PARENT_KEY = "PARENT";
    public static final String SPAN_KEY = "SPAN";
    public static final String BEFORE_KEY = "before";
    public static final String AFTER_KEY = "after";
    public static final String CURRENT_KEY = "current";
    public static final String ANSWER_KEY = "answer";
    public static final String GOLDANSWER_KEY = "goldAnswer";
    public static final String FEATURES_KEY = "features";
    public static final String INTERPRETATION_KEY = "interpretation";
    public static final String ROLE_KEY = "srl";
    public static final String GAZETTEER_KEY = "gazetteer";
    public static final String STEM_KEY = "stem";
    public static final String POLARITY_KEY = "polarity";
    public static final String CH_CHAR_KEY = "char";
    public static final String CH_ORIG_SEG_KEY = "orig_seg"; // the segmentation info existing in the original text
    public static final String CH_SEG_KEY = "seg"; // the segmentation information from the segmenter
    public static final String BEGIN_POSITION_KEY = "BEGIN_POS";
    public static final String END_POSITION_KEY = "END_POS";


    private OldFeatureLabelKeys() {
    }

  } // end static class OldFeatureLabelKeys

}

