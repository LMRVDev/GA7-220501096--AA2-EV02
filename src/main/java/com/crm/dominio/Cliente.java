/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crm.dominio;

/**
 *
 * @author lmrv95
 */
public class Cliente {

    private int id;
    private String address;
    private String city;
    private String name;
    private String neighborhood;
    private String phone_number;

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente() {
    }

    public Cliente(int id, String address, String city, String name, String neighborhood, String phone_number) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.name = name;
        this.neighborhood = neighborhood;
        this.phone_number = phone_number;
    }

    public Cliente(String address, String city, String name, String neighborhood, String phone_number) {
        this.address = address;
        this.city = city;
        this.name = name;
        this.neighborhood = neighborhood;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", neighborhood=" + neighborhood + ", phone_number=" + phone_number + '}';
    }

}
