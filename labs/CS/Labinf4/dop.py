

def xml_to_toml(array):
    with open("dop_5.toml", "w", encoding="utf-8") as out:
        values_array = []
        
        # Первичный проход по XML-строкам и разбиение
        for line in array:
            indent, tag, value, is_closing = divide(line)
            tag_parts = tag_divide(tag)
            
            if tag_parts:
                # Разделяем tag на его составляющие
                tag, inner_tag, inner_value, inner_tags, inner_values = tag_parts
                values_array.append((indent, tag, value, is_closing, inner_tag, inner_value, inner_tags, inner_values))
            else:
                values_array.append((indent, tag, value, is_closing))
        
        # Обработка и запись в TOML-файл
        for indent, tag, value, is_closing, *extras in values_array:
            # Открываем теги
            if not is_closing and value == '':  # Тег с вложенными элементами
                print(f"[{tag}]", file=out)
            elif isinstance(value, list):  # Обработка массива значений
                print(f"{tag} = {value}", file=out)
            else:  # Базовая пара ключ-значение
                print(f"{tag} = \"{value}\"", file=out)
            
            # Добавляем внутренние теги, если они есть
            if extras:
                inner_tag, inner_value, inner_tags, inner_values = extras
                if inner_tag:
                    print(f"{inner_tag} = \"{inner_value}\"", file=out)
                if inner_tags:
                    for itag, ivalue in zip(inner_tags, inner_values):
                        print(f"{itag} = \"{ivalue}\"", file=out)

def tag_divide(tag):
    if '="' in tag:
        inner_tags, inner_values = [], []
        main_tag = tag.split(" ")[0]
        params_str = tag[len(main_tag) + 1:]
        
        while '=' in params_str:
            key, rest = params_str.split('=', 1)
            value, params_str = rest[1:].split('"', 1)
            inner_tags.append(key.strip())
            inner_values.append(value.strip())
        
        return main_tag, inner_tags[0], inner_values[0], inner_tags, inner_values
    return None

def divide(line):
    tag = line[line.find('<')+1:line.find('>')]
    is_closing = '</' in line
    meaning = line[line.find('>')+1:line.find('</')].strip()
    return line.find('<'), tag, meaning, is_closing

def start():
    with open('schedule.xml', encoding="utf-8") as xml_file:
        array = [line for i, line in enumerate(xml_file) if i > 0]
    xml_to_toml(array)

start()
