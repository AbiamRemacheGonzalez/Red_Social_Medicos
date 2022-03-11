<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <tr>
            <td colspan="1">
                <h3 style="color:#9dc7f3;font-family:Lucida Bright;">"<xsl:value-of select="screen/title"></xsl:value-of>"</h3>
            </td>
            <td colspan="2"><p style="color:#a2b7ce"><xsl:value-of select="screen/description"></xsl:value-of></p></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>