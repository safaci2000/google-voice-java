package com.techventus.server.voice.datatypes.records;

import com.techventus.server.voice.datatypes.records.TranscriptElement.RecognitionLevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A Transcript of a voicemail
 *
 * @author Tobias Eisentraeger
 */
public class Transcript {
    private List<TranscriptElement> elements;

    /**
     * Creates a Transcript out of a List of Elements - usage:
     * * <pre>
     * {@code
     * List<TranscriptElement> transElementList = new ArrayList<TranscriptElement>();
     * // go through the array and create transscript elments
     * for (int i = 0; i < transElementsAsString.length; i++) {
     * transElementList.add(TranscriptElement.extractTransscriptElement("<span"+transElementsAsString[i]));
     * }
     * trans = new Transcript(transElementList);
     * }
     * </pre>
     * <p>
     * @param elements
     */
    public Transcript(List<TranscriptElement> elements) {
        super();
        this.elements = elements;
    }

    /**
     * Creates a transcripts with only Text, with RecognitionLevel.UNKNOWN
     *
     * @param simpleTranscript
     */
    public Transcript(String simpleTranscript) {
        super();
        this.elements = new ArrayList<>();
        elements.add(new TranscriptElement(simpleTranscript, null, RecognitionLevel.UNKNOWN));
    }

    /**
     * returns a simple String representation
     */
    public String toString() {
        String ret = "";
        for (Iterator<TranscriptElement> iter = elements.iterator(); iter.hasNext(); ) {
            TranscriptElement element = iter.next();
            if (iter.hasNext() && element != null) {
                ret = ret + element.getText() + " ";
            } else if (element != null) {
                ret = ret + element.getText();
            }
        }
        return ret;
    }

    /**
     * @return the elements
     */
    public List<TranscriptElement> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(List<TranscriptElement> elements) {
        this.elements = elements;
    }


}
