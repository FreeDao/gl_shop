//
//  NSMutableDictionary+Safe.m
//  TCLSales
//
//  Created by River on 14-12-1.
//  Copyright (c) 2014年 Insigma. All rights reserved.
//

#import "NSMutableDictionary+Safe.h"

@implementation NSMutableDictionary (Safe)

- (void)addString:(NSString *)aValue forKey:(id <NSCopying>)aKey
{
    if (aValue == nil) {
        [self setObject:@"" forKey:aKey];
    }
    else
    {
        [self setObject:aValue forKey:aKey];
    }
}

- (void)addInteger:(NSInteger)aValue forKey:(id <NSCopying>)aKey
{
    [self addNumber:[NSNumber numberWithInteger:aValue] forKey:aKey];
}


- (void)addCGFloat:(CGFloat)aValue forKey:(id <NSCopying>)aKey
{
    [self addNumber:[NSNumber numberWithDouble:aValue] forKey:aKey];
}


- (void)addBOOL:(BOOL)aValue forKey:(id <NSCopying>)aKey
{
    //    [self addString:aValue ? @"Y" : @"N" forKey:aKey];
    [self addNumber:[NSNumber numberWithBool:aValue] forKey:aKey];
}

- (void)addBOOLStr:(BOOL)aValue forKey:(id <NSCopying>)aKey
{
    [self addString:aValue ? @"Y" : @"N" forKey:aKey];
}


- (void)addNumber:(NSNumber *)aValue forKey:(id <NSCopying>)aKey
{
    if (aValue == nil) {
        [self setObject:[NSNull null] forKey:aKey];
    }else {
        [self setObject:aValue forKey:aKey];
    }
}

- (void)addArray:(NSArray *)aValue forKey:(id <NSCopying>)aKey
{
    if (aValue == nil) {
        [self setObject:[NSNull null] forKey:aKey];
    }
    else
    {
        [self setObject:aValue forKey:aKey];
    }
}


- (NSString *)convertToJSONString
{
    if ([NSJSONSerialization isValidJSONObject:self])
    {
        NSError *error = nil;
        NSData *jsonData = [NSJSONSerialization dataWithJSONObject:self options:NSJSONWritingPrettyPrinted error: &error];
        NSString *string = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
        return string;
    }
    return nil;
}

@end

@implementation NSDictionary (Json)

- (id)jsonObjectForKey:(id<NSCopying>)key
{
    id value = [self objectForKey:key];
    if ([value isKindOfClass:[NSNull class]]) {
        return nil;
    }
    return value;
}
- (NSMutableDictionary *)dictionaryForKey:(id<NSCopying>)key
{
    NSDictionary *dic = (NSDictionary *)[self jsonObjectForKey:key];
    return [NSMutableDictionary dictionaryWithDictionary:dic];
}

- (NSString *)stringForKey:(id<NSCopying>)key
{
    return [self jsonObjectForKey:key];
}

- (NSNumber *)numberForKey:(id<NSCopying>)key
{
    NSNumber *num = [self jsonObjectForKey:key];
    return num;
}

- (NSInteger)integerForKey:(id<NSCopying>)key
{
    return [self numberForKey:key].integerValue;
}

- (BOOL)boolForKey:(id<NSCopying>)key
{
    id va = [self jsonObjectForKey:key];
    if (va)
    {
        if ([va isKindOfClass:[NSString class]])
        {
            NSString *value = (NSString *)va;
            return [[value lowercaseString] isEqualToString:@"y"];
            
        }
        else
        {
            return [self numberForKey:key].boolValue;
        }
    }
    
    return NO;
    
    
}

- (CGFloat)floatForKey:(id<NSCopying>)key
{
    return [self numberForKey:key].floatValue;
}

- (NSString *)floatValue:(id<NSCopying>)key
{
    CGFloat v = [self floatForKey:key];
    if (v == 0) {
        return nil;
    }
    return [NSString stringWithFormat:@"%.2f", v];
}

- (double)doubleForKey:(id<NSCopying>)key
{
    return [self numberForKey:key].doubleValue;
}

- (NSMutableArray *)arrayForKey:(id<NSCopying>)key
{
    NSArray *array = [self jsonObjectForKey:key];
    
    NSMutableArray *mutablearray = [NSMutableArray array];
    
    for (NSDictionary *dic in array) {
        NSMutableDictionary *mdic = [NSMutableDictionary dictionaryWithDictionary:dic];
        [mutablearray addObject:mdic];
    }
    
    return mutablearray;
}

@end
