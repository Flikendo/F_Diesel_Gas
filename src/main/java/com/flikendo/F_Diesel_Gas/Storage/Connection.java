package com.flikendo.F_Diesel_Gas.Storage;

/**
 * Date: 05-30-2022
 * Author: Flikendo
 *
 * Interface Connection to databases
 */
public interface Connection {
    public boolean connect(String ip, String port);
    public boolean disconnect(String ip, String port);
}
