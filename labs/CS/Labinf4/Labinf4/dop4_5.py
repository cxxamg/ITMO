#toml
array = []


def Xml_To_Toml_2(array):
    with open("dop_5.toml", "w", encoding="utf-8") as out:
        same_tags, all_tags, same_tags_count, nst, notnst = find_same_tags(array)[0], find_same_tags(array)[1], find_same_tags(array)[2], find_same_tags(array)[3], find_same_tags(array)[4]
        #print(same_tags)
        #print(nst)
        #print(notnst)
        cur_tag = (1000,'')
        cur_lil_tag = 0
        values_array = []
        last_tag = 0
        for i in range(len(array)):  #создаем values_array
            tag = divide(array[i])[1]
            indent = divide(array[i])[0]
            value = divide(array[i])[2]
            T = divide(array[i])[3]
            if tag_divide(tag) != None:
                tag = tag_divide(divide(array[i])[1])[0]
                into_tag = tag_divide(divide(array[i])[1])[1]
                into_tag_value = tag_divide(divide(array[i])[1])[2]
                into_tags = tag_divide(divide(array[i])[1])[3]
                into_tags_values = tag_divide(divide(array[i])[1])[4]
                values_array.append((indent,tag,value,T,into_tag,into_tag_value, into_tags, into_tags_values))
            else:
                values_array.append((indent,tag,value,T))
        
        C = False
        c = '['
        check = True
        for i in range(len(values_array)-1): #base
            if values_array[i][1] in notnst and values_array[i+1][1] in notnst: #нехорошо когда тег влож в тег три раза 
                notnst.remove(values_array[i+1][1])

            if values_array[i][1].count('/') == 0:
                slash = False
            else:
                slash = True

            if values_array[i][1] in notnst:
                arr_tag = True
            else:
                arr_tag = False

            if values_array[i][1] in nst:
                lil_tag = True
            else:
                lil_tag = False

            indent = '\t' * (values_array[i][0]//4 + 1)
            n = 0 
            #print(values_array[i][0],values_array[i][1])
            
            if values_array[i][3] != True and not(slash) and not(arr_tag) and not(lil_tag): #пустые и не имеют </ в строчке
                if c == '[':
                    c = c + values_array[i][1]
                    ind_up = values_array[i][0]

                elif ind_up < values_array[i][0]:
                    print(values_array[i][1], values_array[i][0])
                    c = c + '.' + values_array[i][1]
                    ind_up = values_array[i][0]

                elif ind_up > values_array[i][0]:
                    print(ind_up//4 - values_array[i][0]//4)
                    print(values_array[i][1], values_array[i][0])
                    c = c[:c.rfind('.')]
                    c = c[:c.rfind('.')+1]+values_array[i][1]
                    ind_up = values_array[i][0]
                    print(c)
                elif ind_up == values_array[i][0]:
                    c = c[:c.rfind('.') + 1]
                    c = c + values_array[i][1]
                check = True
            elif type(values_array[i][2]) != list and not(slash) and not(arr_tag) and not(lil_tag): #обычная строка
                #print(cur_tag, values_array[i][1])
                if c + ']' != last_tag:
                    print(c + ']', file=out)
                    last_tag = c + ']'
                    print(values_array[i][1] + ' = ' + '"' + values_array[i][2] + '"',file=out)
                else:
                    print(values_array[i][1] + ' = ' + '"' + values_array[i][2] + '"',file=out)


            elif slash: #отдельная строка </
                if check:
                    print('',file=out)
                    check = False

            elif lil_tag: #теги без внутренних элементов(nst)
                print('массив из тега',file=out)
            else:
                #тег с внутренними элементами (notnst)
                print('тег с внут элементами', file=out)


def commas_indent(indent, next_indent):
    if indent == next_indent:
        return ','
    else:
        return ''
    
def commas(value, next_value):
    if value[0] == next_value[0]:
        if value[1].count('/') == 0:  
            return ','
        else:
            if value[1] != '/' + next_value[1]: #если значение == след тегу на одном уровне, то не ставим
                #print(value[1])
                return ''
            else:
                return ','
    else:
        return ''

def find_same_tags(array): #доделать near_same_tags not_near_same_tags
    tags = []
    tags_1 = []
    all_tags = []
    same_tags = []
    same_tags_count = []
    near_same_tags = []
    not_near_same_tags = []
    for i in range(len(array)):
        if tag_divide(divide(array[i])[1]) != None:
            tags.append((divide(array[i])[0], tag_divide(divide(array[i])[1])[0]))
            tags_1.append(tag_divide(divide(array[i])[1])[0])
            all_tags.append(tag_divide(divide(array[i])[1])[0])
        elif divide(array[i])[1][0] != '/':
            tags.append((divide(array[i])[0], divide(array[i])[1]))
            tags_1.append(divide(array[i])[1])
            all_tags.append(divide(array[i])[1])
        else:
            all_tags.append(divide(array[i])[1])
        if array[i].count('<') == 2:
            all_tags.append('/'+divide(array[i])[1])
    tags = sorted(tags, key=lambda x: x[0])
    for i in range(len(tags)-1):  
        if tags[i] == tags[i+1]:
            same_tags.append((tags[i][1]))
    for i in set(same_tags):
        same_tags_count.append(same_tags.count(i)+1)
    #print(tags_1)
    for i in range(len(tags_1)-1):
        if tags_1[i] == tags_1[i+1]:
            near_same_tags.append(tags_1[i])
    not_near_same_tags = list(set(same_tags) - set(near_same_tags))
    return list(set(same_tags)), all_tags, same_tags_count, near_same_tags, not_near_same_tags

def tag_divide(tag):
    if tag.find('="') != -1:
        #print(tag.count('='))
        index1 = -1
        index2 = -1
        into_tag_arguments = []
        into_tags = []
        line = tag[tag.find(" ")+1:]
        for i in range(tag.count('=')):
            #print(line)
            #print(line.find("="))
            into_tags.append(line[:line.find('=')])
            line = line[line.find('=')+2:]
            into_tag_arguments.append(line[:line.find('"')])
            line = line[line.find('"')+2:]
        #print(into_tags)
        #print(into_tag_arguments)
        main_tag = tag[:tag.find(" ")] #tag
        into_tag_argument = tag[tag.find('="')+2:-1] #аргумент тега в теге
        into_tag = tag[tag.find(" ")+1:tag.find('="')] #тег в теге (name)
        return main_tag, into_tag, into_tag_argument, into_tags, into_tag_arguments 
    else:
        return None

def array_converter(line, n):
    c = '\t' * n + divide(line)[0] * ' ' + '"' + divide(line)[1] + '"' + ':' + ' [\n'
    for i in divide(line)[2]:
        c = c + '\t' * n + (divide(line)[0]) * ' ' +'\t' + i 
        if i != divide(line)[2][-1]:
            c = c + ',\n'
        else:
            c = c + '\n'
    c = c + '\t' * n + divide(line)[0] * ' ' + ']'
    return c

def divide(line):

    tag = line[line.find('<')+1:line.find('>')]
    T = False
    meaning = line[line.find('>')+1:line.find('</')]
    if line.strip().find('</') != -1:  #для всех с </
        T = True
    #if meaning.count(',') != 0 and tag != "building" and tag != "paragraph":  #тут если видим запятые => массив, кроме тега building 
        #meaning = [i.strip() for i in meaning.split(',')]
    return line.find('<'), tag, meaning, T   #line.find('<') для сохранения отступов 

def start():
    xml_file = open('schedule.xml')
    i = True
    for line in xml_file:
        if i:
            i = False  
            continue    #пропускаем 1 строку <?xml version="1.0" encoding="UTF-8" ?>
        else:
            array.append(line)
    #Xml_To_JSON(array)
    Xml_To_Toml_2(array)

start()