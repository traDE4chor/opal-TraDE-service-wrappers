
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
 *         &lt;element name="energyConfiguration" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
 *         &lt;element name="lx" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ly" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="lz" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numberOfSnapshots" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="snapshotFrequency" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="checkpointFrequency" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="resultOpalInput" type="{http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/}tDataElementRef"/&gt;
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
    "energyConfiguration",
    "lx",
    "ly",
    "lz",
    "numberOfSnapshots",
    "snapshotFrequency",
    "checkpointFrequency",
    "resultOpalInput"
})
@XmlRootElement(name = "prepareOpalMCInputs")
public class PrepareOpalMCInputs {

    @XmlElement(required = true)
    protected TSimulationIdentifier simulationIdentifier;
    @XmlElement(required = true)
    protected String replyToCallbackAddress;
    @XmlElement(required = true)
    protected TDataModelReference dataModelRef;
    @XmlElement(required = true)
    protected TDataElementRef energyConfiguration;
    protected int lx;
    protected int ly;
    protected int lz;
    protected int numberOfSnapshots;
    protected int snapshotFrequency;
    protected int checkpointFrequency;
    @XmlElement(required = true)
    protected TDataElementRef resultOpalInput;

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
     * Ruft den Wert der energyConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getEnergyConfiguration() {
        return energyConfiguration;
    }

    /**
     * Legt den Wert der energyConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setEnergyConfiguration(TDataElementRef value) {
        this.energyConfiguration = value;
    }

    /**
     * Ruft den Wert der lx-Eigenschaft ab.
     * 
     */
    public int getLx() {
        return lx;
    }

    /**
     * Legt den Wert der lx-Eigenschaft fest.
     * 
     */
    public void setLx(int value) {
        this.lx = value;
    }

    /**
     * Ruft den Wert der ly-Eigenschaft ab.
     * 
     */
    public int getLy() {
        return ly;
    }

    /**
     * Legt den Wert der ly-Eigenschaft fest.
     * 
     */
    public void setLy(int value) {
        this.ly = value;
    }

    /**
     * Ruft den Wert der lz-Eigenschaft ab.
     * 
     */
    public int getLz() {
        return lz;
    }

    /**
     * Legt den Wert der lz-Eigenschaft fest.
     * 
     */
    public void setLz(int value) {
        this.lz = value;
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
     * Ruft den Wert der snapshotFrequency-Eigenschaft ab.
     * 
     */
    public int getSnapshotFrequency() {
        return snapshotFrequency;
    }

    /**
     * Legt den Wert der snapshotFrequency-Eigenschaft fest.
     * 
     */
    public void setSnapshotFrequency(int value) {
        this.snapshotFrequency = value;
    }

    /**
     * Ruft den Wert der checkpointFrequency-Eigenschaft ab.
     * 
     */
    public int getCheckpointFrequency() {
        return checkpointFrequency;
    }

    /**
     * Legt den Wert der checkpointFrequency-Eigenschaft fest.
     * 
     */
    public void setCheckpointFrequency(int value) {
        this.checkpointFrequency = value;
    }

    /**
     * Ruft den Wert der resultOpalInput-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDataElementRef }
     *     
     */
    public TDataElementRef getResultOpalInput() {
        return resultOpalInput;
    }

    /**
     * Legt den Wert der resultOpalInput-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDataElementRef }
     *     
     */
    public void setResultOpalInput(TDataElementRef value) {
        this.resultOpalInput = value;
    }

}
