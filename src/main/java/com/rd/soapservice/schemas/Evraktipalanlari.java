//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.03 at 09:58:20 AM TRT 
//


package com.rd.soapservice.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipadi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kullanici" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sifre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tipadi",
    "kullanici",
    "sifre"
})
@XmlRootElement(name = "evraktipalanlari")
public class Evraktipalanlari {

    protected String tipadi;
    protected String kullanici;
    protected String sifre;

    /**
     * Gets the value of the tipadi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipadi() {
        return tipadi;
    }

    /**
     * Sets the value of the tipadi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipadi(String value) {
        this.tipadi = value;
    }

    /**
     * Gets the value of the kullanici property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKullanici() {
        return kullanici;
    }

    /**
     * Sets the value of the kullanici property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKullanici(String value) {
        this.kullanici = value;
    }

    /**
     * Gets the value of the sifre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * Sets the value of the sifre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifre(String value) {
        this.sifre = value;
    }

}
