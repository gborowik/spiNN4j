package com.spiNN4j.io.parser;

import com.spiNN4j.io.ioManager.FolderManager;
import com.spiNN4j.model.data.DataMatrix;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Grzegorz Borowik on 2016-06-16 2:19 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class CSVParserDoubleTest {
    @Test
    public void parse() throws Exception {
        CSVParserDouble parser = new CSVParserDouble(inputStreamFrom("./src/test/resources/", "sam1_eeg.csv"));

        DataMatrix<Double> matrix = parser.parse();

        assertThat(Arrays.asList(3985.1, 4393.3, 4439.5, 3662.100, 5061, 3990.8, 04573.8, 4036.9, 4717.9, 4225.6, 4638.5, 4157.9, 4496.4, 4007.7)
                .stream().map(el -> el.doubleValue()).collect(Collectors.toList()))
                .isEqualTo(matrix.get(0).getRow());

        assertThat(Arrays.asList(3988.2, 4392.8, 4453.3, 3660, 5040.5, 3976.9, 4581.5, 4033.8, 4732.8, 4235.4, 4649.2, 4170.8, 4506.2, 4015.9)
                .stream().map(el -> el.doubleValue()).collect(Collectors.toList()))
                .isEqualTo(matrix.get(127).getRow());
    }


    private InputStream inputStreamFrom(String folder, String file) {
        return new FolderManager(folder).inputStreamsFilesMatch(file).get(0);
    }

}