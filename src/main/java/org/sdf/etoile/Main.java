package org.sdf.etoile;

import lombok.RequiredArgsConstructor;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Map;

@RequiredArgsConstructor
public final class Main implements Runnable {
    private final SparkSession spark;
    private final Map<String, String> args;

    public static void main(final String[] args) {
        new Main(
                SparkSession.builder()
                        .getOrCreate(),
                new Args(args)
        ).run();
    }

    @Override
    public void run() {
        final Dataset<Row> df = this.spark.read()
                .format("com.databricks.spark.avro")
                .options(
                        new PrefixArgs(
                                "input",
                                this.args
                        )
                )
                .load();
        df.write()
                .format("csv")
                .options(
                        new PrefixArgs(
                                "output",
                                this.args
                        )
                )
                .save();
    }
}
