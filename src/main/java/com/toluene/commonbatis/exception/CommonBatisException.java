package com.toluene.commonbatis.exception;


/**
 * The base {@link Throwable} type for commonBatis.
 * <p/>
 * Note that all {@link java.sql.SQLException SQLExceptions} will be wrapped in some form of
 * {@link JDBCException}.
 * TODO should be implemented latter
 *
 * @see JDBCException
 */
public class CommonBatisException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommonBatisException(String message) {
        super(message);
    }

    public CommonBatisException(Throwable root) {
        super(root);
    }

    public CommonBatisException(String message, Throwable root) {
        super(message, root);
    }
}






