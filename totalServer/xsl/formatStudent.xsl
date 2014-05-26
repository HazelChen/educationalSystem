<?xml version="1.0" encoding="UTF-8"?>
<xsl:stysheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/students">
		<students>
			<xsl:for-each select="student">
				<student>
							<id>
								<xsl:value-of select="学号"/>
								<xsl:value-of select="Sno"/>
								
							</id>
							<name>
								<xsl:value-of select="名称"/>
								<xsl:value-of select="姓名"/>
								<xsl:value-of select="Snm"/>
							</name>
							<sex>
								<xsl:value-of seclect="性别"/>
								<xsl:value-of select="Sex"/>
							</sex>
							<major>
								<xsl:value-of select="专业"/>
								<xsl:value-of select="Sde"/>
							</major>
				</student>
			</xsl:for-each>
		</students>
</xsl:template>
</xsl:stysheet>