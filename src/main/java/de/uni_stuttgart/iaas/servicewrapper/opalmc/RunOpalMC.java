
package de.uni_stuttgart.iaas.servicewrapper.opalmc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="simulationIdentifier" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tSimulationIdentifier"/&gt;
 *         &lt;element name="replyToCallbackAddress" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dataModelRef" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataModelReference"/&gt;
 *         &lt;element name="opalInput" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
 *         &lt;element name="opalBccLattice" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
 *         &lt;element name="numberOfSnapshots" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="resultSnapshots" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
 *         &lt;element name="resultSaturation" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
 *         &lt;element name="resultReport" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
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
    "simulationIdentifier",
    "replyToCallbackAddress",
    "dataModelRef",
    "opalInput",
    "opalBccLattice",
    "numberOfSnapshots",
    "resultSnapshots",
    "resultSaturation",
    "resultReport"
})
@XmlRootElement(name = "runOpalMC")
public class RunOpalMC {

    @XmlElement(required = true)
    protected TSimulationIdentifier simulationIdentifier;
    @XmlElement(required = true)
    protected String replyToCallbackAddress;
    @XmlElement(required = true)
    protected TDataModelReference dataModelRef;
    @XmlElement(required = true)
    protected TDataElementRef opalInput;
    @XmlElement(required = true)
    protected TDataElementRef opalBccLattice;
    protected int numberOfSnapshots;
    @XmlElement(required = true)
    protected TDataElementRef resultSnapshots;
    @XmlElement(required = true)
    protected TDataElementRef resultSaturation;
    @XmlElement(required = true)
    protected TDataElementRef resultReport;

    /**
     * Ruft den Wert der simulationIdentifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSimulationIdentifier }
     *     
     */
    public TSimulationIdentifier getSimulationIdentifier() {
        return simulationIdentifier;
    }

    /**
     * Legt den Wert der simulationIdentifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSimulationIdentifier }
     *     
     */
    public void setSimulationIdentifier(TSimulationIdentifier value) {
        this.simulationIdentifier = value;
    }

    /**
     * Ruft den Wert der replyToCallbackAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyToCallbackAddress() {
        return replyToCallbackAddress;
    }

    /**
     * Legt den Wert der replyToCallbackAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyToCallbackAddress(String value) {
        this.replyToCallbackAddress = value;
    }

    /**
     * Ruft den Wert der dataModelRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataModelReference }
     *     
     */
    public TDataModelReference getDataModelRef() {
        return dataModelRef;
    }

    /**
     * Legt den Wert der dataModelRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataModelReference }
     *     
     */
    public void setDataModelRef(TDataModelReference value) {
        this.dataModelRef = value;
    }

    /**
     * Ruft den Wert der opalInput-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getOpalInput() {
        return opalInput;
    }

    /**
     * Legt den Wert der opalInput-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setOpalInput(TDataElementRef value) {
        this.opalInput = value;
    }

    /**
     * Ruft den Wert der opalBccLattice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getOpalBccLattice() {
        return opalBccLattice;
    }

    /**
     * Legt den Wert der opalBccLattice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setOpalBccLattice(TDataElementRef value) {
        this.opalBccLattice = value;
    }

    /**
     * Ruft den Wert der numberOfSnapshots-Eigenschaft ab.
     * 
     */
    public int getNumberOfSnapshots() {
        return numberOfSnapshots;
    }

    /**
     * Legt den Wert der numberOfSnapshots-Eigenschaft fest.
     * 
     */
    public void setNumberOfSnapshots(int value) {
        this.numberOfSnapshots = value;
    }

    /**
     * Ruft den Wert der resultSnapshots-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getResultSnapshots() {
        return resultSnapshots;
    }

    /**
     * Legt den Wert der resultSnapshots-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setResultSnapshots(TDataElementRef value) {
        this.resultSnapshots = value;
    }

    /**
     * Ruft den Wert der resultSaturation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getResultSaturation() {
        return resultSaturation;
    }

    /**
     * Legt den Wert der resultSaturation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setResultSaturation(TDataElementRef value) {
        this.resultSaturation = value;
    }

    /**
     * Ruft den Wert der resultReport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getResultReport() {
        return resultReport;
    }

    /**
     * Legt den Wert der resultReport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setResultReport(TDataElementRef value) {
        this.resultReport = value;
    }

}
