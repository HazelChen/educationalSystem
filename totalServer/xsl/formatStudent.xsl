<?xml version="1.0" encoding="UTF-8"?>
<xsl:stysheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8">
	<xsl:template match="Students">
	 <xsl:apply-templates/>
		<Students>
			<xsl:for-each select="student">
				<student>
					<xsl:choose>
						<xsl:when test="A">
							<id>
								<xsl:value-of select="学号"/>
							</id>
							<name>
								<xsl:value-of select="名称"/>
							</name>
							<sex>
								<xsl:value-of seclect="性别"/>
							</sex>
							<major>
								<xsl:value-of select="专业"/>
							</major>
						</xsl:when>
						<xsl:when test="B">
							<id>
								<xsl:value-of select="学号"/>
							</id>
							<name>
								<xsl:value-of select="姓名"/>
							</name>
							<sex>
								<xsl:value-of seclect="性别"/>
							</sex>
							<major>
								<xsl:value-of select="院系"/>
							</major>
						</xsl:when>
						<xsl:when test="C">
							<id>
								<xsl:value-of select="Sno"/>
							</id>
							<name>
								<xsl:value-of select="Snm"/>
							</name>
							<sex>
								<xsl:value-of seclect="Sex"/>
							</sex>
							<major>
								<xsl:value-of select="Sde"/>
							</major>
						</xsl:when>
					</xsl:choose>
				</student>
			</xsl:for-each>
		</Students>
</xsl:template>
</xsl:output>
</xsl:stysheet>