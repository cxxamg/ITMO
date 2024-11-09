import xmltodict
import json
a = ''
xml_file = open('schedule.xml')
for i in xml_file:
    a = a + i
parsed_xml_file = xmltodict.parse(a)
json_file = json.dumps(parsed_xml_file,ensure_ascii=False, indent=4)
with open("dop_1.json", "w", encoding="utf-8") as out:
    print(json_file, file=out)
