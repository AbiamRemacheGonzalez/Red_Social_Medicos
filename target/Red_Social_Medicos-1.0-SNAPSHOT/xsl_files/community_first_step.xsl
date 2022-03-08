<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="Community">
        <screen><xsl:apply-templates/></screen>
    </xsl:template>
    <xsl:template match="Community/communityId">
        <id><xsl:apply-templates/></id>
    </xsl:template>
    <xsl:template match="Community/communityName">
        <name><xsl:apply-templates/></name>
    </xsl:template>
    <xsl:template match="Community/communityDescription">
        <description><xsl:apply-templates/></description>
    </xsl:template>
</xsl:stylesheet>