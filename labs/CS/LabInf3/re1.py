import re
#[<)

file = open('txt1')
array1 = list(line.strip('\n') for line in file)
print(array1)
file.close()

for n in array1:
    count = len(re.findall(r'\[<\)',n))
    print(f'test {array1.index(n)+1}: {count}')

file = open('txt2')
array2 = list(line.strip('\n') for line in file)
print(f'\n{array2}')
file.close()

#БВГДЖЗЙКЛМНПРСТФХЦЧШЩ
#АОУЭЫИЯЕЁЮ
for i in array2:
    check = False
    str_array2 = re.split(r'\W+', i) #разбиваем строку на массив из слов
    for m1 in re.finditer(r'\w*[аоуэыияеёю]{2}\w*',i, flags=re.IGNORECASE): #слова две подряд идущие гласные
        if m1 and str_array2.index(m1[0]) != len(str_array2)-1:
            check = m1
            sogl_count = 0
            for m2 in re.finditer(r'[бвгджзйклмнпрстфхцчшщ]', str_array2[str_array2.index(m1[0]) + 1], flags=re.IGNORECASE): #все согл. след. слова
                sogl_count += 1 
            if sogl_count <= 3:                    
                print(f'test {array2.index(i)+1}: "{m1[0]}" ({sogl_count} согл. "{str_array2[str_array2.index(m1[0]) + 1]}")')
            else:
                print(f'test {array2.index(i)+1}: - ({sogl_count} согл. "{str_array2[str_array2.index(m1[0]) + 1]}")')
    if not(check):
        print(f'test {array2.index(i)+1}: Нет подходящих слов')


file = open('txt3')
array3 = list(line.strip('\n') for line in file)
print(f'\n{array3}')
file.close()

for i in array3:
    result_array = []
    words_array3 = re.split(r'\W+', i) 
    for word in words_array3:
            glasn_array = list(m[0] for m in re.finditer(r'[аоуэыияеёю]', word, flags=re.IGNORECASE))
            if len(list(set(glasn_array))) == 1:
                result_array.append(word)
    if len(result_array) != 0:
        print(f'test {array3.index(i)+1}: {sorted(result_array, key=lambda x: (len(x), x.lower()))}')
    else:
        print(f'test {array3.index(i)+1}: Нет подходящих слов')