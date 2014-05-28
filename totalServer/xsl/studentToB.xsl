<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/students">
	<students>
		<xsl:for-each select="student">
			<student>
				<学号>
					<xsl:value-of select="id"/>
				</学号>
				<姓名>
					<xsl:value-of select="name"/>
				</姓名>
				<性别>
					<xsl:choose>
					<xsl:when test="sex='FEMALE'">女</xsl:when>
					<xsl:when test="sex='MALE'">男</xsl:when>
					</xsl:choose>
				</性别>
				<院系>
					<xsl:value-of select="major"/>
				</院系>
				<关联账户>0</关联账户>
				
			</student>
		</xsl:for-each>
	</students>	
	</xsl:template>
</xsl:stylesheet>