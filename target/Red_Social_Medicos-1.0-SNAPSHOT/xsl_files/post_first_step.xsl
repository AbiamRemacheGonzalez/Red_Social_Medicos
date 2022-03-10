<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="Post">
        <screen><xsl:apply-templates/></screen>
    </xsl:template>
    <xsl:template match="Post/postId">
        <id><xsl:apply-templates/></id>
    </xsl:template>
    <xsl:template match="Post/communityId">
        <communityId><xsl:apply-templates/></communityId>
    </xsl:template>
    <xsl:template match="Post/userId">
        <userId><xsl:apply-templates/></userId>
    </xsl:template>
    <xsl:template match="Post/postTitle">
        <title><xsl:apply-templates/></title>
    </xsl:template>
    <xsl:template match="Post/postDescription">
        <description><xsl:apply-templates/></description>
    </xsl:template>
    <xsl:template match="Post/creationDate">
        <date><xsl:apply-templates/></date>
    </xsl:template>
    <xsl:template match="Post/postEvaluation">
        <evaluation><xsl:apply-templates/></evaluation>
    </xsl:template>
    <xsl:template match="Post/comments">
        <comments><xsl:apply-templates/></comments>
    </xsl:template>
</xsl:stylesheet>