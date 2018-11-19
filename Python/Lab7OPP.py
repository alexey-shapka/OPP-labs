# /* ==========================================
# Основи Паралельного програмування
# Лабораторна робота №7
# Потоки в мові програмування Python
# F1: d  = (B * C) + (A * B) + (C * (B * (MA * ME)))
# F2: MF = (MG * MH) * (MK + ML)
# F3: S  = SORT(MS * MT) * O - P 
# Шапка Олексій Володимирович ІО-62
# дата: 16.11.2018
# ========================================== */


import Objects as Obj
import Operations as Opr
import asyncio
import pprint


async def FirstFunction(time):
    print('Thread 1 started...')
    await asyncio.sleep(time)
    A = Obj.CreateVector(4,1)
    B = Obj.CreateVector(4,1)
    C = Obj.CreateVector(4,1)
    MA = Obj.CreateMatrix(4,1)
    ME = Obj.CreateMatrix(4,1)
    #sleep
    Result = Opr.MultiplyVectors(B, C) + Opr.MultiplyVectors(A, B) + Opr.MultiplyVectors(Opr.MultiplyMatrixVector(Opr.MultiplyMatrix(MA, ME), B),C)
    print('\nFunction 1 result:\n' + str(Result))

async def SecondFunction(time):
    print('Thread 2 started...')
    await asyncio.sleep(time)
    MG = Obj.CreateMatrix(4,2)
    MH = Obj.CreateMatrix(4,2)
    MK = Obj.CreateMatrix(4,2)
    ML = Obj.CreateMatrix(4,2)

    Result = Opr.MultiplyMatrix(Opr.MultiplyMatrix(MG, MH),Opr.SumMatrix(MK, ML))

    prettyList = pprint.pformat(Result)
    print('\nFunction 2 result:\n' + prettyList)

async def ThirdFunction(time):
    print('Thread 3 started...')
    await asyncio.sleep(time)
    O = Obj.CreateVector(4,3)
    P = Obj.CreateVector(4,3)
    MS = Obj.CreateMatrix(4,3)
    MT = Obj.CreateMatrix(4,3)

    Result = Opr.SubtractVectors(Opr.MultiplyMatrixVector(Opr.SortMatrix(Opr.MultiplyMatrix(MS, MT)), O), P)
    print('\nFunction 3 result:\n' + str(Result))

def main():
    print("Main Thread Started: \n")
    ioloop = asyncio.get_event_loop()
    tasks = [ioloop.create_task(FirstFunction(3)), ioloop.create_task(SecondFunction(2)), ioloop.create_task(ThirdFunction(1))]
    wait_tasks = asyncio.wait(tasks)
    ioloop.run_until_complete(wait_tasks)
    print("\nMain process finished.")
    ioloop.close()

main()