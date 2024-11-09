
line = '    <company name="ооо Компания">Негры</company>'
#line = '<description>'
line = '<employee id="101">'
tag = line[line.find('<')+1:line.find('>')]
if tag.find('="') != -1:
    print(tag)
    print(tag[:tag.find(" ")]) #tag
    print(tag[tag.find('="')+2:-1]) #аргумент тега в теге
    print(tag[tag.find(" ")+1:tag.find('="')]) #тег в теге (name)




meaning = line[line.find('>')+1:line.find('</')]
if meaning == '' and line.strip().find('</') not in [-1,0]:
    print(True, line.find('</'))
print(meaning)
