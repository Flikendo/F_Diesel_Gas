package com.flikendo.F_Diesel_Gas.Storage;

/**
 * Date: 05-30-2022
 * Author: Flikendo
 *
 * Class which uses Cassandra as database. Main queries are launched from here.
 */
public class CassandraDB implements Connection{
    private String ip;
    private String port;
    private boolean isConnected;

    /**
     * Connects to database
     * @param ip String. Represents the IP
     * @param port String. Represents the PORT
     * @return boolean. Whether it is connected returns true, otherwise return false
     */
    //TODO: Implements ths method
    @Override
    public boolean connect(String ip, String port) {
        return false;
    }

    /**
     * Disconnects from database
     * @param ip String. Represents the IP
     * @param port String. Represents the PORT
     * @return boolean. Whether it is disconnected returns true, otherwise it returns false
     */
    //TODO: Implements this method
    @Override
    public boolean disconnect(String ip, String port) {
        return false;
    }


}
