//
// Translated by CS2J (http://www.cs2j.com): 8/18/2017 3:07:36 PM
//

package org.hl7.fhir.r4.utils.transform.deserializer;


public enum FhirMapUseNames
{
    /**
     'source'
     */
    NotSet,

    /**
     'source'
     */
    Source,

    /**
     'target'
     */
    Target,

    /**
     'queried'
     */
    Queried,

    /**
     'produced'
     */
    Produced;

    public static final int SIZE = java.lang.Integer.SIZE;

    public String getValue()
    {
      switch (this) {
        case Source:
          return "source";
        case Queried:
          return "queried";
        case Target:
          return "target";
        case Produced:
          return "produced";
        default:
          return "?";
      }
    }


    public static FhirMapUseNames forValue(int value)
    {
        return values()[value];
    }
}

