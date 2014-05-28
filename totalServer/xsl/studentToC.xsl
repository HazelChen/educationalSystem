<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="students">
	<students>
		<xsl:for-each select="student">
			<student>
				<Sno>
					<xsl:value-of select="id"/>
				</Sno>
				<Snm>
					<xsl:value-of select="name"/>
				</Snm>
				<Sex>
					<xsl:choose>
					<xsl:when test="sex='FEMALE'">f</xsl:when>
					<xsl:when test="sex='MALE'">m</xsl:when>
					</xsl:choose>
				</Sex>
				<Sde>
					<xsl:value-of select="major"/>
				</Sde>
				<Pwd>0</Pwd>	
			</student>
		</xsl:for-each>
	</students>	
	</xsl:template>
</xsl:stylesheet>