package org.jpgough.birthday;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.model.Request;
import com.atlassian.oai.validator.model.SimpleRequest;
import com.atlassian.oai.validator.report.ValidationReport;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class ValidateSpecificationTests {

    private Logger LOGGER = LoggerFactory.getLogger(ValidateSpecificationTests.class);

    private OpenApiInteractionValidator validator;

    @Before
    public void before() {
        validator = OpenApiInteractionValidator.createFor("/oai/spec.json").build();
    }

    @Test
    public void is_a_valid_request_on_simple_get() {
        final Request request = SimpleRequest.Builder
                .get("today")
                .build();

        ValidationReport validationReport = validator.validateRequest(request);
        LOGGER.info(validationReport.toString());
        assertFalse(validationReport.hasErrors());
    }

    @Test
    public void fail_request_on_invalid_get() {
        final Request request = SimpleRequest.Builder
                .get("broken")
                .build();

        ValidationReport validationReport = validator.validateRequest(request);
        LOGGER.info(validationReport.toString());
        assertTrue(validationReport.hasErrors());
    }

    @Test
    public void post_with_no_body_fails() {
        final Request request = SimpleRequest.Builder
                .post("day")
                .withContentType("application/json;charset=utf8")
                .build();

        ValidationReport validationReport = validator.validateRequest(request);
        LOGGER.info(validationReport.toString());
        assertTrue(validationReport.hasErrors());
    }

    @Test
    public void post_with_invalid_body_fails() {
        final Request request = SimpleRequest.Builder
                .post("day")
                .withContentType("application/json;charset=utf8")
                .withBody("{}")
                .build();

        ValidationReport validationReport = validator.validateRequest(request);
        LOGGER.info(validationReport.toString());
        assertTrue(validationReport.hasErrors());
    }

    @Test
    public void post_succeeds_with_valid_body() {
        final Request request = SimpleRequest.Builder
                .post("day")
                .withContentType("application/json;charset=utf8")
                .withBody("{\n" +
                        "  \"date\": \"29-09-2019\"\n" +
                        "}")
                .build();

        ValidationReport validationReport = validator.validateRequest(request);
        LOGGER.info(validationReport.toString());
        assertFalse(validationReport.hasErrors());
    }

    @Test
    public void post_succeeds_with_extra_fields_fails() {
        final Request request = SimpleRequest.Builder
                .post("day")
                .withContentType("application/json;charset=utf8")
                .withBody("{\n" +
                        "  \"date\": \"29-09-2019\",\n" +
                        "  \"invalid\": \"invalid-field\"\n" +
                        "}")
                .build();

        ValidationReport validationReport = validator.validateRequest(request);
        LOGGER.info(validationReport.toString());
        assertTrue(validationReport.hasErrors());
    }
}
