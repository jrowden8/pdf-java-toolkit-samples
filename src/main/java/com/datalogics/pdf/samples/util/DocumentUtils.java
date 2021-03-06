/*
 * Copyright 2015 Datalogics, Inc.
 */

package com.datalogics.pdf.samples.util;

import com.adobe.internal.io.ByteReader;
import com.adobe.internal.io.InputStreamByteReader;
import com.adobe.pdfjt.core.exceptions.PDFIOException;
import com.adobe.pdfjt.core.exceptions.PDFInvalidDocumentException;
import com.adobe.pdfjt.core.exceptions.PDFSecurityException;
import com.adobe.pdfjt.pdf.document.PDFDocument;
import com.adobe.pdfjt.pdf.document.PDFOpenOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * A utility class that contains some commonly used document methods.
 */
public final class DocumentUtils {

    /**
     * This is a utility class, and won't be instantiated.
     */
    private DocumentUtils() {}

    /**
     * Open a PDF file using an input path.
     *
     * @param inputPath The PDF resource to open
     * @return A new {@link PDFDocument} instance of the input document
     * @throws PDFInvalidDocumentException a general problem with the PDF document, which may now be in an invalid state
     * @throws PDFIOException there was an error reading or writing a PDF file or temporary caches
     * @throws PDFSecurityException some general security issue occurred during the processing of the request
     * @throws IOException an I/O operation failed or was interrupted
     */
    public static PDFDocument openPdfDocument(final String inputPath)
                    throws PDFInvalidDocumentException, PDFIOException, PDFSecurityException, IOException {
        ByteReader reader = null;
        PDFDocument document = null;

        final InputStream inputStream = DocumentUtils.class.getResourceAsStream(inputPath);
        reader = new InputStreamByteReader(inputStream);
        document = PDFDocument.newInstance(reader, PDFOpenOptions.newInstance());

        return document;
    }

    /**
     * Open a PDF file using an input path.
     *
     * @param inputUrl The URL to a PDF file to open
     * @return A new PDFDocument instance of the input document
     * @throws PDFInvalidDocumentException a general problem with the PDF document, which may now be in an invalid state
     * @throws PDFIOException there was an error reading or writing a PDF file or temporary caches
     * @throws PDFSecurityException some general security issue occurred during the processing of the request
     * @throws IOException an I/O operation failed or was interrupted
     */
    public static PDFDocument openPdfDocument(final URL inputUrl)
                    throws IOException, PDFInvalidDocumentException, PDFIOException, PDFSecurityException {
        final PDFOpenOptions pdfOpenOptions = PDFOpenOptions.newInstance();

        return openPdfDocumentWithOptions(inputUrl, pdfOpenOptions);
    }

    /**
     * Open a PDF file using an input path.
     *
     * @param inputUrl The URL to a PDF file to open
     * @param pdfOpenOptions Options used to open a PDF document
     * @return A new PDFDocument instance of the input document
     * @throws PDFInvalidDocumentException a general problem with the PDF document, which may now be in an invalid state
     * @throws PDFIOException there was an error reading or writing a PDF file or temporary caches
     * @throws PDFSecurityException some general security issue occurred during the processing of the request
     * @throws IOException an I/O operation failed or was interrupted
     */
    public static PDFDocument openPdfDocumentWithOptions(final URL inputUrl, final PDFOpenOptions pdfOpenOptions)
                    throws IOException, PDFInvalidDocumentException, PDFIOException, PDFSecurityException {
        ByteReader reader = null;
        PDFDocument document = null;

        final InputStream inputStream = inputUrl.openStream();
        reader = new InputStreamByteReader(inputStream);
        document = PDFDocument.newInstance(reader, pdfOpenOptions);

        return document;
    }
}
