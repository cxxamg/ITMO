import timeit

tasks = ['labinf4', 'dop4_1', 'dop4_2', 'dop4_3']
for task in tasks:
    elapsed_time = timeit.timeit(f'import {task}', number=100)
    print(f'{task} время: ', elapsed_time)