package com.toluene.commonbatis.util;

/**
 * replace the symbol of tableName with actually tableName
 */
public class TableNameParser {

    private final String openToken;
    private final String closeToken;
    private final String actTableName;

    public TableNameParser(String openToken, String closeToken, String actTableName) {
        this.openToken = openToken;
        this.closeToken = closeToken;
        this.actTableName = actTableName;
    }

    public String parse(String text) {
        StringBuilder builder = new StringBuilder();
        if (text != null && text.length() > 0) {
            char[] src = text.toCharArray();
            int offset = 0;
            int start = text.indexOf(openToken, offset);
            while (start > -1) {
                if (start > 0 && src[start - 1] == '\\') {
                    builder.append(src, offset, start - 1).append(openToken);
                    offset = start + openToken.length();
                } else {
                    int end = text.indexOf(closeToken, start + 1);
                    if (end == -1) {
                        builder.append(src, offset, src.length - offset);
                        offset = src.length;
                    } else {
                        builder.append(src, offset, start - offset);
                        builder.append(actTableName);
                        offset = end + closeToken.length();
                    }
                }
                start = text.indexOf(openToken, offset);
            }
            if (offset < src.length) {
                builder.append(src, offset, src.length - offset);
            }
        }
        return builder.toString();
    }

}
