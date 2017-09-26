
package com.sun.common.vo;

public enum BatchType {

	SEND_LINE("A", "batch_send_line"),

    SEND_EMAIL("B", "batch_send_email")

    ;

    /** The langKey. */
    private String langKey;

    /** The value. */
    private String value;


    /**
     * Instantiates a new report code.
     *
     * @param value the value
     * @param langKey the langKey
     */
    BatchType(final String value, final String langKey) {
        this.value = value;
        this.langKey = langKey;
    }

    /**
     * Lookup.
     *
     * @param batchId the sys code
     * @return the report code
     */
    public static final BatchType lookup(final String batchId) {
        BatchType returnType = null;
        for (BatchType reportCode : BatchType.values()) {
            if (reportCode.getValue().equals(batchId)) {
                returnType = reportCode;
            }
        }
        return returnType;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets the langKey.
     *
     * @return the langKey
     */
    public String getlangKey() {
        return this.langKey;
    }

}
