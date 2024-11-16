array = []
def validate_xml_lines(xml_lines):
    """
    Проверяет синтаксический корректность XML построчно без дополнительных библиотек.
    
    :param xml_lines: Список строк XML
    :return: None, выводит результаты проверки
    """
    opened_tags = []  # Стек для отслеживания открытых тегов

    for i, line in enumerate(xml_lines):
        stripped_line = line.strip()  # Убираем лишние пробелы
        
        # Разбиваем строку на теги
        while "<" in stripped_line:
            start_index = stripped_line.find("<")
            end_index = stripped_line.find(">", start_index)
            
            if end_index == -1:
                print(f"Ошибка: Незакрытый тег в строке {i + 1}: {line.strip()}")
                return False
            
            tag = stripped_line[start_index + 1:end_index].strip()
            stripped_line = stripped_line[end_index + 1:]  # Оставляем остаток строки
            
            # Определяем тип тега
            if tag.startswith("?") or tag.startswith("!"):  # Пропускаем служебные теги
                continue
            elif tag.startswith("/"):  # Закрывающий тег
                tag_name = tag[1:]
                if not opened_tags or opened_tags[-1] != tag_name:
                    print(f"Ошибка: Несоответствие тегов в строке {i + 1}: </{tag_name}> не соответствует <{opened_tags[-1] if opened_tags else 'нет открытого тега'}>")
                    return False
                opened_tags.pop()
            elif tag.endswith("/"):  # Самозакрывающийся тег
                continue
            else:  # Открывающий тег
                tag_name = tag.split()[0]
                opened_tags.append(tag_name)

    # Проверяем незакрытые теги
    if opened_tags:
        print(f"Ошибка: Незакрытые теги: {opened_tags}")
        return False
    else:
        print("XML синтаксически корректен.")
        return True

def start():
    xml_path = "testing_dop3.xml"  # Укажите путь к XML-файлу
    xml_file = open(xml_path)
    i = True
    for line in xml_file:
        if i:
            i = False  
            continue    #пропускаем 1 строку <?xml version="1.0" encoding="UTF-8" ?>
        else:
            array.append(line)
    #Xml_To_JSON(array)


    if validate_xml_lines(array):
        print("Переход к обработке файла.")
        #Xml_To_JSON_2(array)
    else:
        print("Исправьте ошибки в XML перед обработкой.")

start()