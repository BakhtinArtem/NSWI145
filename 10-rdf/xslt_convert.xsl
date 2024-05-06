<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#"
    xmlns:math="xalan://java.lang.Math"
    xmlns:ex="http://example.com/damage#">
  <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:variable name="prefix">https://example.org/iana/media-types/</xsl:variable>
  <xsl:template match="damageDetails">
    <xsl:text>@prefix ex: &lt;http://example.com/damage#&gt; .&#10;</xsl:text>
    <xsl:text>@prefix rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .&#10;</xsl:text>
    <xsl:text>@prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .&#10;</xsl:text>
    <xsl:text>@prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt; .&#10;</xsl:text>
    <xsl:text>@prefix dcterms: &lt;http://purl.org/dc/terms/&gt; .&#10;</xsl:text>
    <xsl:apply-templates/>
  </xsl:template>
  
  
  <xsl:template match="damageDetail">
    
    <xsl:variable name="date" select="date"/>
    <xsl:variable name="desc" select="desc"/>
    <xsl:variable name="type" select="type"/>
    <xsl:variable name="id" select="translate(date, '.', '')"/>
    
    

    <xsl:text>&#10;</xsl:text>
    <xsl:value-of select="concat('ex:', $id)"/>
    <xsl:text> a ex:DamageDetail ;&#10;</xsl:text>
    <xsl:text>    dcterms:date &quot;</xsl:text><xsl:value-of select="$date"/><xsl:text>&quot;^^xsd:date ;&#10;</xsl:text>
    <xsl:text>    dcterms:description &quot;</xsl:text><xsl:value-of select="$desc"/><xsl:text>&quot;@en ;&#10;</xsl:text>
    <xsl:text>    ex:type ex:</xsl:text><xsl:value-of select="$type"/><xsl:text> .&#10;</xsl:text>
  </xsl:template>
 
  
  <xsl:template match="text()"/>

</xsl:stylesheet>
