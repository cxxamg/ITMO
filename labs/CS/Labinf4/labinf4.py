import xml.etree.ElementTree as ET
array = []

def Xml_To_JSON(array):
    with open("output1.json", "w", encoding="utf-8") as out:
        print("{", file=out)
        for i in range(len(array) - 1):
            if divide(array[i])[1].count('/') == 0 and divide(array[i])[2] == '': #теги формата <...>  в  (...): {
                print('\t' + divide(array[i])[0] * ' ' + '"' + divide(array[i])[1] + '"' + ':' +' {', file=out)

            elif divide(array[i])[2] != '' and type(divide(array[i])[2]) != list: #аргумент не пуст и не список
                c = divide(array[i])[0] * ' ' + '"' + divide(array[i])[1] + '"' + ': ' + '"' + str(divide(array[i])[2])+ '"'
                if divide(array[i])[0] > divide(array[i+1])[0]:   #Запятая не ставится если отступ след строки < нынешней 
                    print('\t' + c, file=out)
                else:
                    print('\t' + c + ',', file=out)

            elif type(divide(array[i])[2]) == list: #аргументом явл. список
                print(array_converter(array[i]), file=out)

            elif divide(array[i])[1].count('/') != 0:     #теги формата </..>  в }
                c = divide(array[i])[0] * ' ' + '}'
                if divide(array[i])[0] > divide(array[i+1])[0]:  #Запятая не ставится если отступ след строки < нынешней 
                    print('\t' + c, file=out)
                else:
                    print('\t' + c + ',', file=out)
        print('\t' + divide(array[-1])[0] * ' ' + '}', file=out) #тк (len(array) - 1), послед тег из списка преобраз вручную в }
        print('}', file=out)

def array_converter(mini_array):
    c = '\t' + divide(mini_array)[0] * ' ' + '"' + divide(mini_array)[1] + '"' + ':' + ' [\n'
    for i in divide(mini_array)[2]:
        c = c + '\t' + (divide(mini_array)[0]) * ' ' +'\t' + i 
        if i != divide(mini_array)[2][-1]:
            c = c + ',\n'
        else:
            c = c + '\n'
    c = c + '\t' + divide(mini_array)[0] * ' ' + '],'
    return c

def divide(line):

    tag = line[line.find('<')+1:line.find('>')]
    meaning = line[line.find('>')+1:line.find('</')]
    #if meaning.count(',') != 0 and tag != "building":  #тут если видим запятые => массив, кроме тега building 
        #meaning = [i.strip() for i in meaning.split(',')]
    return line.find('<'), tag, meaning    #line.find('<') для сохранения отступов 

def validate_xml(xml_file_path):
    try:
        # Попытка разобрать XML
        tree = ET.parse(xml_file_path)
        root = tree.getroot()  # Доступ к корневому элементу (проверяем его доступность)
        print(f"XML синтаксически корректен. Корневой элемент: <{root.tag}>")
        return True
    except ET.ParseError as e:
        print(f"Ошибка синтаксиса XML: {e}")
        return False
    except FileNotFoundError:
        print(f"Файл не найден: {xml_file_path}")
        return False

def start():
    xml_path = "schedule.xml"  # Укажите путь к XML-файлу
    if validate_xml(xml_path):
        xml_file = open(xml_path)
        i = True
        for line in xml_file:
            if i:
                i = False  
                continue    #пропускаем 1 строку <?xml version="1.0" encoding="UTF-8" ?>
            else:
                array.append(line)
    #Xml_To_JSON(array)
        Xml_To_JSON(array)
    else:
        print("Исправьте ошибки в XML перед обработкой.")

start()
