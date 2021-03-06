package com.knappsack.swagger4springweb.parser;

import com.knappsack.swagger4springweb.AbstractTest;
import com.knappsack.swagger4springweb.testController.MockController;
import com.wordnik.swagger.model.Model;
import com.wordnik.swagger.model.Parameter;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

import static junit.framework.Assert.assertTrue;

public class ApiParameterParserTest extends AbstractTest {

    @Test
    public void documentationParameterTest() throws NoSuchMethodException {
        Class controllerClass = MockController.class;
        Method method = controllerClass
                .getMethod("getTestPojoRequestParams", String.class, Boolean.class, Byte.class, Long.class,
                        Integer.class, Float.class, Double.class, Date.class);
        ApiParameterParser parameterParser = new ApiParameterParser(new ArrayList<String>(),
                new HashMap<String, Model>());
        List<Parameter> documentationParameters = parameterParser.parseApiParametersAndArgumentModels(method);
        assertTrue(documentationParameters.size() == 8);
        Parameter documentationParameter = documentationParameters.get(0);
        assertTrue(documentationParameter.dataType().equals("string"));
        assertTrue(documentationParameter.name().equals("testVariable"));
    }

}
