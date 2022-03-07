<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="Community">
        <screen><xsl:apply-templates/></screen>
    </xsl:template>
    <xsl:template match="Community/communityId">
        <field label="communityId"><xsl:apply-templates/></field>
    </xsl:template>
    <xsl:template match="Community/communityName">
        <field label="communityName"><xsl:apply-templates/></field>
    </xsl:template>
    <xsl:template match="Community/communityDescription">
        <field label="communityDescription"><xsl:apply-templates/></field>
    </xsl:template>
</xsl:stylesheet>