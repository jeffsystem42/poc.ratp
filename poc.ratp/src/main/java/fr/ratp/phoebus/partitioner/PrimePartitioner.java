package fr.ratp.phoebus.partitioner;

import org.apache.log4j.Logger;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Partitioner des itemProcessor gérés par le compositeItemProcessor
 */
public class PrimePartitioner implements Partitioner {

    /** LOGGER - Logger */
    private static final Logger LOGGER = Logger.getLogger(PrimePartitioner.class);

    private String tableNamePrefix = null;

    public void setTableNamePrefix(String tableNamePrefix) {
        this.tableNamePrefix = tableNamePrefix;
    }

    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> result  = new HashMap<String, ExecutionContext>();

        for (int i = 1; i <= gridSize; i++) {
            ExecutionContext value = new ExecutionContext();

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Demarrage du Thread" + i);
            }

            // Numéro de la partition
            value.putInt("partitionNumber", i);

            // Nom du thread
            value.putString("name", "Thread" + i);

            // Nom de la table
            value.putString("tableName", tableNamePrefix+i);

            result.put("partition" + i, value);
        }

        return result;
    }
}
