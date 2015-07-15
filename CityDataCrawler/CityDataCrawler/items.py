# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class CitydatacrawlerItem(scrapy.Item):
    zip = scrapy.Field()   #zip code
    zcpi2011 = scrapy.Field()    #zip code population in 2011: (include estimated ones)
    zcpi2010 = scrapy.Field()    #zip code population in 2010: (include estimated ones)
    zcpi2000 = scrapy.Field()    #zip code population in 2010: (include estimated ones)
    wp = scrapy.Field()    #White population
    bp = scrapy.Field()    #Black population
    aip = scrapy.Field()    #American Indian population
    ap = scrapy.Field()    #Asian population
    nhaopip = scrapy.Field()    #Native Hawaiian and Pacific Islander population
    sorp = scrapy.Field()    #Some other races population
    tomrp = scrapy.Field()    #two or more races population
    holp = scrapy.Field()    #Hispanic or Latino population
    males = scrapy.Field()    #Number of Males
    females = scrapy.Field()    #Number of Females
    hac = scrapy.Field()    #Houses and condos
    roa = scrapy.Field()    #Renter-occupied apartments
    coliizc = scrapy.Field()    #cost of living index in zip code
    la = scrapy.Field()    #Land area      sq. mi.
    wa = scrapy.Field()    #water area      sq. mi.
    pd = scrapy.Field()    #Population density     How many people per sq mile