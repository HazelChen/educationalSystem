<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/students">
		<students>
			<xsl:for-each select="student">
				<student>
					<id>
						<xsl:value-of select="学号" />
						<xsl:value-of select="Sno" />

					</id>
					<name>
						<xsl:value-of select="名称" />
						<xsl:value-of select="姓名" />
						<xsl:value-of select="Snm" />
					</name>
					<sex>
					<xsl:choose>
					<xsl:when test="性别='男'">MALE</xsl:when>
					<xsl:when test="性别='女'">FEMALE</xsl:when>
					<xsl:when test="Sex='m'">MALE</xsl:when>
					<xsl:when test="Sex='f'">FEMALE</xsl:when>
					</xsl:choose>
					</sex>
					<major>
						<xsl:value-of select="专业" />
						<xsl:value-of select="Sde" />
						<xsl:value-of select="院系" />
					</major>
				</student>
			</xsl:for-each>
		</students>
	</xsl:template>
</xsl:stylesheet>